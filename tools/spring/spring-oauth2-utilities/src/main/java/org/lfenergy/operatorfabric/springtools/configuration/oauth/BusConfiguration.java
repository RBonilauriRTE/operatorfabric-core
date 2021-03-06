/* Copyright (c) 2018, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.lfenergy.operatorfabric.springtools.configuration.oauth;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>This configuration class registers all custom events from specified basePackages with Spring Cloud Bus.</p>
 * Created on 12/02/19
 *
 * @author Alexandra Guironnet
 */
@Configuration
@RemoteApplicationEventScan(basePackages = "org.lfenergy.operatorfabric.springtools.config.oauth")
public class BusConfiguration {

}
