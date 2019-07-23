/*
 * This file is generated by jOOQ.
 */
package palindrome.db.jooq.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import palindrome.db.jooq.tables.Palindromedata;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PalindromedataRecord extends UpdatableRecordImpl<PalindromedataRecord> implements Record3<Integer, String, Timestamp> {

    private static final long serialVersionUID = 785844659;

    /**
     * Setter for <code>public.palindromedata.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.palindromedata.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.palindromedata.payload</code>.
     */
    public void setPayload(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.palindromedata.payload</code>.
     */
    public String getPayload() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.palindromedata.created_timestamp</code>.
     */
    public void setCreatedTimestamp(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.palindromedata.created_timestamp</code>.
     */
    public Timestamp getCreatedTimestamp() {
        return (Timestamp) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Timestamp> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Timestamp> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Palindromedata.PALINDROMEDATA.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Palindromedata.PALINDROMEDATA.PAYLOAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Palindromedata.PALINDROMEDATA.CREATED_TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getPayload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getCreatedTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPayload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreatedTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PalindromedataRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PalindromedataRecord value2(String value) {
        setPayload(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PalindromedataRecord value3(Timestamp value) {
        setCreatedTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PalindromedataRecord values(Integer value1, String value2, Timestamp value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PalindromedataRecord
     */
    public PalindromedataRecord() {
        super(Palindromedata.PALINDROMEDATA);
    }

    /**
     * Create a detached, initialised PalindromedataRecord
     */
    public PalindromedataRecord(Integer id, String payload, Timestamp createdTimestamp) {
        super(Palindromedata.PALINDROMEDATA);

        set(0, id);
        set(1, payload);
        set(2, createdTimestamp);
    }
}