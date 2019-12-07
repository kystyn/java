package ru.spbstu.pipeline;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Set;

public interface Producer {

    @NotNull Set<String> DEFAULT_TYPES = Collections.singleton(byte[].class.getCanonicalName());

    interface DataAccessor {

        @NotNull Object get();

        /**
         * @return Size of data. byteArray.length or string.length() if data has type String or ...
         */
        long size();
    }

    /**
     * @param typeName Canonical type name.
     * @return Data accessor for specified type.
     */
    @NotNull DataAccessor getAccessor(@NotNull String typeName);

    /**
     * <p>Types of output data producer can produce.</p>
     * <p>Class canonical name is for example String.class.getCanonicalName().</p>
     *
     * @return Set of canonical names of producer's possible output types.
     */
    @NotNull
    default Set<String> outputDataTypes() {
        return DEFAULT_TYPES;
    }
}
