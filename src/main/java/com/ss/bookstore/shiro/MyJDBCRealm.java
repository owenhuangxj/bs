//package com.ss.bookstore.authority;
//
//import org.apache.catalina.realm.JDBCRealm;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.util.JdbcUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//public class MyJDBCRealm extends JDBCRealm {
//    /**
//     * The default query used to retrieve account data for the user.
//     */
//    protected static final String DEFAULT_AUTHENTICATION_QUERY = "SELECT pass FROM user WHERE username = ?";
//
//    /**
//     * The default query used to retrieve the roles that apply to a user.
//     */
//    protected static final String DEFAULT_USER_ROLES_QUERY =
//            // from user self
//            "SELECT r.role_name FROM user_roles ur "
//                    + "JOIN user u USING(user_id) "
//                    + "JOIN roles r USING(role_id) "
//                    + "WHERE u.username = ? = ? "
//                    + "UNION "
//                    // from his groups
//                    + "SELECT r.role_name FROM user_roles_groups urg "
//                    + "JOIN user u ON(urg.user_id=u.user_id) "
//                    + "JOIN roles_groups_roles rgr USING(roles_group_id) "
//                    + "JOIN roles r ON(rgr.role_id = r.role_id) "
//                    + "WHERE u.username = ? ";
//
//    protected String authenticationQuery = DEFAULT_AUTHENTICATION_QUERY;
//
//    protected String userRolesQuery = DEFAULT_USER_ROLES_QUERY;
//
//    protected boolean permissionsLookupEnabled = false;
//
//    private static final Logger log = LoggerFactory.getLogger(MyJDBCRealm.class);
//
//    /**
//     * jndiDataSourceName
//     */
//    protected String jndiDataSourceName;
//    private DataSource dataSource;
//
//
//    public String getJndiDataSourceName() {
//        return jndiDataSourceName;
//    }
//
//    public void setJndiDataSourceName(String jndiDataSourceName) {
//        this.jndiDataSourceName = jndiDataSourceName;
//        this.dataSource = getDataSourceFromJNDI(jndiDataSourceName);
//    }
//
//    private DataSource getDataSourceFromJNDI(String jndiDataSourceName) {
//        try {
//            InitialContext ic = new InitialContext();
//            return (DataSource) ic.lookup(jndiDataSourceName);
//        } catch (NamingException e) {
//            log.error("JNDIr while retrieving " + jndiDataSourceName, e);
//            throw new AuthorizationException(e);
//        }
//    }
//
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        String username = upToken.getUsername();
//
//        // Null username is invalid
//        if (username == null) {
//            throw new AccountException("Null usernames are not allowed by this realm.");
//        }
//
//        Connection conn = null;
//        AuthenticationInfo info = null;
//        try {
//            conn = dataSource.getConnection();
//
//            String password = getPasswordForUser(conn, username);
//
//            if (password == null) {
//                throw new UnknownAccountException("No account found for user [" + username + "]");
//            }
//
//            info = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
//
//        } catch (SQLException e) {
//            final String message = "There was a SQL error while authenticating user [" + username + "]";
//            log.error(message, e);
//
//            // Rethrow any SQL errors as an authentication exception
//            throw new AuthenticationException(message, e);
//        } finally {
//            JdbcUtils.closeConnection(conn);
//        }
//
//        return info;
//    }
//
//    private String getPasswordForUser(Connection conn, String username)
//            throws SQLException {
//
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String password = null;
//        try {
//            ps = conn.prepareStatement(authenticationQuery);
//            ps.setString(1, username);
//
//            // Execute query
//            rs = ps.executeQuery();
//
//            // Loop over results - although we are only expecting one result,
//            // since usernames should be unique
//            boolean foundResult = false;
//            while (rs.next()) {
//
//                // Check to ensure only one row is processed
//                if (foundResult) {
//                    throw new AuthenticationException(
//                            "More than one user row found for user ["
//                                    + username + "]. Usernames must be unique.");
//                }
//
//                password = rs.getString(1);
//
//                foundResult = true;
//            }
//        } finally {
//            JdbcUtils.closeResultSet(rs);
//            JdbcUtils.closeStatement(ps);
//        }
//
//        return password;
//    }
//
//    protected Set getRoleNamesForUser(Connection conn, String username) throws SQLException {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set roleNames = new LinkedHashSet();
//
//        try {
//            ps = conn.prepareStatement(userRolesQuery);
//            ps.setString(1, username);
//            ps.setString(2, username);
//
//            // Execute query
//            rs = ps.executeQuery();
//
//            // Loop over results and add each returned role to a set
//            while (rs.next()) {
//
//                String roleName = rs.getString(1);
//
//                // Add the role to the list of names if it isn't null
//                if (roleName != null) {
//                    roleNames.add(roleName);
//                } else {
//                    if (log.isWarnEnabled()) {
//                        log.warn("Null name found while retrieving role names for user [" + username + "]");
//                    }
//                }
//            }
//        } finally {
//            JdbcUtils.closeResultSet(rs);
//            JdbcUtils.closeStatement(ps);
//        }
//
//        return roleNames;
//    }
//}
