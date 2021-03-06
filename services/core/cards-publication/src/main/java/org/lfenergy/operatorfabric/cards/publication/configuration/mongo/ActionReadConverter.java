/* Copyright (c) 2018, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.lfenergy.operatorfabric.cards.publication.configuration.mongo;

import org.bson.Document;
import org.lfenergy.operatorfabric.cards.model.ActionEnum;
import org.lfenergy.operatorfabric.cards.publication.model.Action;
import org.lfenergy.operatorfabric.cards.publication.model.ActionPublicationData;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

/**
 *
 * <p>Spring converter registered in mongo conversions</p>
 * <p>Converts {@link Document} to {@link Action} using {@link ActionPublicationData} builder</p>
 *
 * @author David Binder
 */
public class ActionReadConverter implements Converter<Document,Action> {

    private I18nReadConverter i18nReadConverter = new I18nReadConverter();
    private InputReadConverter inputReadConverter = new InputReadConverter();

    @Override
    public Action convert(Document source) {
        ActionPublicationData.ActionPublicationDataBuilder builder = ActionPublicationData.builder()
                .type(ActionEnum.valueOf(source.getString("type")))
                .label(i18nReadConverter.convert((Document) source.get("label")))
                .buttonStyle(source.getString("buttonStyle"))
                .called(source.getBoolean("called"))
                .contentStyle(source.getString("contentStyle"))
                .hidden(source.getBoolean("hidden"))
                .lockAction(source.getBoolean("lockAction"))
                .lockCard(source.getBoolean("lockCard"))
                .needsConfirm(source.getBoolean("needsConfirm"))
                .updateState(source.getBoolean("updateState"))
                .updateStateBeforeAction(source.getBoolean("updateStateBeforeAction"))
                ;
        List<Document> inputs = (List<Document>) source.get("inputs");
        if(inputs!=null){
            for(Document d : inputs){
                builder.input(inputReadConverter.convert(d));
            }
        }

        return builder.build();
    }
}
