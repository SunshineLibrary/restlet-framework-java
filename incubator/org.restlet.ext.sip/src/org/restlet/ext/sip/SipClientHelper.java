/**
 * Copyright 2005-2009 Noelios Technologies.
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

package org.restlet.ext.sip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.restlet.Client;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.engine.http.connector.BaseClientHelper;

/**
 * SIP client helper based on NIO blocking sockets.
 * 
 * @author Jerome Louvel
 */
public class SipClientHelper extends BaseClientHelper {

    /**
     * Constructor.
     * 
     * @param client
     *            The client to help.
     */
    public SipClientHelper(Client client) {
        super(client);
        getProtocols().add(Protocol.SIP);
        getProtocols().add(Protocol.SIPS);
    }

    @Override
    public Socket createSocket(boolean secure, String hostDomain, int hostPort)
            throws UnknownHostException, IOException {
        // TODO: parameterize the SIP proxy !
        return super.createSocket(secure, "localhost", 5060);
    }

    @Override
    public Method parseMethod(String methodName) {
        return SipMethod.valueOf(methodName);
    }

    @Override
    public synchronized void start() throws Exception {
        getLogger().info("Starting the SIP client");
        super.start();
    }

    @Override
    public synchronized void stop() throws Exception {
        getLogger().info("Stopping the SIP client");
        super.stop();
    }
}