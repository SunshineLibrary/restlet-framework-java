/**
 * Copyright 2005-2011 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.oauth;

import org.restlet.data.Reference;

/**
 * Container for OAuth2 Parameters. It contains the following information
 * <ul>
 * <li>baseRef - defaults to "http://localhost:8080/oauth/"</a>
 * <li>authorizePath - defaults to "authorize"
 * <li>
 * <li>accessTokenPath - defaults to "access_token"</li>
 * <li>scope - string with space delimited scopes</li>
 * <li>clientId</li>
 * <li>clientSecret</li>
 * </ul>
 * 
 * @author Kristoffer Gronowski
 */
public class OAuthParameters {

    final String clientId;

    final String clientSecret;

    Reference baseRef = new Reference("http://localhost:8080/oauth/");

    String scope;

    String authorizePath = "authorize";

    String accessTokenPath = "access_token";

    String owner = null;

    /**
     * Create a new OAuthParameters object with specfied clientId and secret
     */
    public OAuthParameters(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Create a new OAuthParameters object with specfied clientId, secret, and
     * baseRef
     */
    public OAuthParameters(String clientId, String clientSecret, String baseRef) {
        this(clientId, clientSecret);
        this.baseRef = new Reference(baseRef);
    }

    /**
     * Create a new OAuthParameters object with specfied clientId, secret,
     * baseRef and scope
     */
    public OAuthParameters(String clientId, String clientSecret,
            String baseRef, String scope) {
        this(clientId, clientSecret, baseRef);
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public Reference getBaseRef() {
        return baseRef;
    }

    public String getScope() {
        return scope;
    }

    public String getAuthorizePath() {
        return authorizePath;
    }

    public String getAccessTokenPath() {
        return accessTokenPath;
    }

    public void setAuthorizePath(String authorizePath) {
        this.authorizePath = authorizePath;
    }

    public void setAccessTokenPath(String accessTokenPath) {
        this.accessTokenPath = accessTokenPath;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}