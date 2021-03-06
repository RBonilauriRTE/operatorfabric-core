/* Copyright (c) 2018, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.lfenergy.operatorfabric.cards.publication.repositories;

import org.lfenergy.operatorfabric.cards.publication.model.ArchivedCardPublicationData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * <p>Auto generated spring mongo reactive repository to access Archived Card collection</p>
 *
 * @author David Binder
 */
@Repository
public interface ArchivedCardRepository extends ReactiveMongoRepository<ArchivedCardPublicationData,String> {

    public Flux<ArchivedCardPublicationData> findByProcessId(String processId);
}
