/*
 * This file is generated by jOOQ.
 */
package palindrome.db.jooq;


import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import palindrome.db.jooq.tables.Palindromedata;
import palindrome.db.jooq.tables.records.PalindromedataRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PalindromedataRecord> PALINDROMEDATA_PKEY = UniqueKeys0.PALINDROMEDATA_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<PalindromedataRecord> PALINDROMEDATA_PKEY = Internal.createUniqueKey(Palindromedata.PALINDROMEDATA, "palindromedata_pkey", Palindromedata.PALINDROMEDATA.ID);
    }
}