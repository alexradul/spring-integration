/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.xmpp.messages;

import org.jivesoftware.smack.packet.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Handle display of incoming XMPP messages to this user.
 *
 * @author Josh Long
 * @author Mark Fisher
 * @since 2.0
 */
@Component
public class XmppMessageConsumer {

	@ServiceActivator
	public void consume(Object input) throws Throwable {
		String text = null;
		if (input instanceof Message) {
			text = ((Message) input).getBody();
		} else if (input instanceof String) {
			text = (String) input;
		} else {
			throw new IllegalArgumentException(
					"expected either a Smack Message or a String, but received: " + input);
		}
		System.out.println("================================================================================");
		System.out.println("message: " + text);
	}

}
