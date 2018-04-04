package com.walmartlabs.concord.server.org.secret;

/*-
 * *****
 * Concord
 * -----
 * Copyright (C) 2017 - 2018 Wal-Mart Store, Inc.
 * -----
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
 * =====
 */

import com.walmartlabs.concord.server.api.org.secret.SecretStoreEntry;
import com.walmartlabs.concord.server.api.org.secret.SecretStoreResource;
import com.walmartlabs.concord.server.org.secret.store.SecretStore;
import org.sonatype.siesta.Resource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SecretStoreResourceImpl implements SecretStoreResource, Resource {

    private final SecretManager secretManager;

    @Inject
    public SecretStoreResourceImpl(SecretManager secretManager) {
        this.secretManager = secretManager;
    }

    @Override
    public List<SecretStoreEntry> listActiveStores() {
        List<SecretStoreEntry> activeStores = new ArrayList<>();
        for (SecretStore secretStore : secretManager.getActiveSecretStores()) {
            activeStores.add(new SecretStoreEntry(secretStore.getType(), secretStore.getDescription()));
        }

        return activeStores;
    }
}
