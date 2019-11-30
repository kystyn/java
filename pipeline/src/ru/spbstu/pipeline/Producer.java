package ru.spbstu.pipeline;

import java.util.Collections;
import java.util.Set;

public interface Producer extends Fallible {

    interface DataAccessor {

        Object get();
        long size();
    }

    /**
     * @param typeName Canonical type name.
     * @return Data access for specified type.
     */
    DataAccessor getAccessor(String typeName);

    /**
     * Types of output data producer can produce.
     * Class canonical name is for example String.class.getCanonicalName().
     * @return Set of canonical names of producer's possible output types.
     */
    default Set<String> outputDataTypes() {
        return Collections.singleton(byte[].class.getCanonicalName());
    }
}
