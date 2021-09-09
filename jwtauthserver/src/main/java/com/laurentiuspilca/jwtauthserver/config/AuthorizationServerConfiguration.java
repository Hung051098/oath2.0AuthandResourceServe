//package com.laurentiuspilca.jwtauthserver.config;
//
//@Configuration
//@EnableAuthorizationServer
//protected static class AuthorizationServerConfiguration extends
//        AuthorizationServerConfigurerAdapter {
//
//    @Autowired 
//    private TokenStore tokenStore;
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(this.tokenStore)
//                .authenticationManager(this.authenticationManager)
//                .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("app")
//                .authorizedGrantTypes("password", "refresh_token")
//                .authorities("USER")
//                .scopes("read", "write")
//                .resourceIds("rest_service")
//                .secret("secret")
//                .accessTokenValiditySeconds(24 * 365 * 60 * 60);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        PasswordEncoder passwordEncoder = new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence != null ? charSequence.toString() : null;
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return charSequence != null && s != null && charSequence.toString().equals(s) ? true : false;
//            }
//        };
//        oauthServer.passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setSupportRefreshToken(true);
//        tokenServices.setTokenStore(this.tokenStore);
//        return tokenServices;
//    }
//
//}