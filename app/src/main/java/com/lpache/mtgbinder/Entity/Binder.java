package com.lpache.mtgbinder.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 10/07/15.
 */
public class Binder implements Serializable, Parcelable{

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

    private int idBinder;
    private String nameBinder;
    private ArrayList<Binder_Card> bindersCards_binder;

    /**
     * Default constructor.
     */
    public Binder() {

    }

    /**
     * @return the idBinder
     */
    public int getIdBinder() {
        return this.idBinder;
    }

    /**
     * @param value the idBinder to set
     */
    public void setIdBinder(final int value) {
        this.idBinder = value;
    }

    /**
     * @return the nameBinder
     */
    public String getNameBinder() {
        return this.nameBinder;
    }

    /**
     * @param value the nameBinder to set
     */
    public void setNameBinder(final String value) {
        this.nameBinder = value;
    }

    /**
     * @return the bindersCards_binder
     */
    public ArrayList<Binder_Card> getBindersCards_binder() {
        return this.bindersCards_binder;
    }

    /**
     * @param value the bindersCards_binder to set
     */
    public void setBindersCards_binder(final ArrayList<Binder_Card> value) {
        this.bindersCards_binder = value;
    }

    /**
     * This stub of code is regenerated. DO NOT MODIFY.
     *
     * @param dest Destination parcel
     * @param flags flags
     */
    public void writeToParcelRegen(Parcel dest, int flags) {
        if (this.parcelableParents == null) {
            this.parcelableParents = new ArrayList<Parcelable>();
        }
        if (!this.parcelableParents.contains(this)) {
            this.parcelableParents.add(this);
        }
        dest.writeInt(this.getIdBinder());
        dest.writeString(this.getNameBinder());

        if (this.getBindersCards_binder() != null) {
            dest.writeInt(this.getBindersCards_binder().size());
            for (Binder_Card item : this.getBindersCards_binder()) {
                if (!this.parcelableParents.contains(item)) {
                    item.writeToParcel(this.parcelableParents, dest, flags);
                } else {
                    dest.writeParcelable(null, flags);
                }
            }
        } else {
            dest.writeInt(-1);
        }
        this.parcelableParents = null;
    }

    /**
     * Regenerated Parcel Constructor.
     *
     * This stub of code is regenerated. DO NOT MODIFY THIS METHOD.
     *
     * @param parc The parcel to read from
     */
    public void readFromParcel(Parcel parc) {
        this.setIdBinder(parc.readInt());
        this.setNameBinder(parc.readString());

        int nbBindersCards_binder = parc.readInt();
        if (nbBindersCards_binder > -1) {
            ArrayList<Binder_Card> items =
                    new ArrayList<Binder_Card>();
            for (int i = 0; i < nbBindersCards_binder; i++) {
                items.add((Binder_Card) parc.readParcelable(
                        Binder_Card.class.getClassLoader()));
            }
            this.setBindersCards_binder(items);
        }
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public Binder(Parcel parc) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.readFromParcel(parc);

        // You can  implement your own parcel mechanics here.

    }

    /* This method is not regenerated. You can implement your own parcel mechanics here. */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.writeToParcelRegen(dest, flags);
        // You can  implement your own parcel mechanics here.
    }

    /**
     * Use this method to write this entity to a parcel from another entity.
     * (Useful for relations)
     *
     * @param parents The entity being parcelled that need to parcel this one
     * @param dest The destination parcel
     * @param flags The flags
     */
    public synchronized void writeToParcel(List<Parcelable> parents, Parcel dest, int flags) {
        this.parcelableParents = new ArrayList<Parcelable>(parents);
        dest.writeParcelable(this, flags);
        this.parcelableParents = null;
    }

    @Override
    public int describeContents() {
        // This should return 0
        // or CONTENTS_FILE_DESCRIPTOR if your entity is a FileDescriptor.
        return 0;
    }

    /**
     * Parcelable creator.
     */
    public static final Parcelable.Creator<Binder> CREATOR
            = new Parcelable.Creator<Binder>() {
        public Binder createFromParcel(Parcel in) {
            return new Binder(in);
        }

        public Binder[] newArray(int size) {
            return new Binder[size];
        }
    };

}
