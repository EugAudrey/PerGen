/* Copyright 2007 Jacques Berger

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.jberger.pergen.transformers;

import java.util.Collection;
import java.util.HashMap;
import org.jberger.pergen.domain.Entity;
import org.jberger.pergen.domain.Field;
import org.jberger.pergen.domain.GlobalInformations;
import org.jberger.pergen.exceptions.AmbiguousEntityNameException;
import org.jberger.pergen.exceptions.AmbiguousFieldNameException;

/**
 * Performs the transformations of original names into sql names.
 */
public final class SqlTransformer {

    /**
     * To avoid instanciation.
     */
    private SqlTransformer() {
    }

    /**
     * Apply the sql transformations to the entities and fields.
     * @param infos The global informations.
     */
    public static void transform(final GlobalInformations infos) {
        transformEntities(infos.getEntities());
    }

    /**
     * Transform the entity names.
     * @param entities A collection of entities.
     */
    private static void transformEntities(
                                final Collection<Entity> entities) {
        HashMap<String, Entity> producedNames =
                                    new HashMap<String, Entity>();

        for (Entity entity : entities) {
            String sqlName = entity.getSqlName();

            Entity possibleDuplicate = producedNames.get(sqlName);
            if (possibleDuplicate != null) {
                throw new AmbiguousEntityNameException(entity.getOriginalName(),
                                            possibleDuplicate.getOriginalName(),
                                            sqlName);
            }

            producedNames.put(sqlName, entity);
            transformFields(entity.getOriginalName(), entity.getFields());
        }
    }

    /**
     * Transform the field names.
     * @param entityName The name of the entity.
     * @param fields A collection of fields in the entity.
     */
    private static void transformFields(final String entityName,
                                   final Collection<Field> fields) {
        HashMap<String, Field> producedNames =
                                     new HashMap<String, Field>();

        for (Field field : fields) {
            String sqlName = field.getSqlName();

            Field possibleDuplicate = producedNames.get(sqlName);
            if (possibleDuplicate != null) {
                throw new AmbiguousFieldNameException(field.getOriginalName(),
                                            possibleDuplicate.getOriginalName(),
                                            entityName, sqlName);
            }

            producedNames.put(sqlName, field);
        }
    }

    public static String transformIdentifier(String identifier) {
	return identifier.toUpperCase();
    }
}
