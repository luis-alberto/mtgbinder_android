package com.lpache.mtgbinder.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 10/07/15.
 */
public class Binder_Card implements Serializable, Parcelable  {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

    private int id;
    private int quantity;
    private Card card;
    private Binder binder;
    private Quality quality;
    private Language language;




    /**
     * Default constructor.
     */
    public Binder_Card() {

    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param value the id to set
     */
    public void setId(final int value) {
        this.id = value;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @param value the quantity to set
     */
    public void setQuantity(final int value) {
        this.quantity = value;
    }

    /**
     * @return the card
     */
    public Card getCard() {
        return this.card;
    }

    /**
     * @param value the card to set
     */
    public void setCard(final Card value) {
        this.card = value;
    }

    /**
     * @return the binder
     */
    public Binder getBinder() {
        return this.binder;
    }

    /**
     * @param value the binder to set
     */
    public void setBinder(final Binder value) {
        this.binder = value;
    }

    /**
     * @return the quality
     */
    public Quality getQuality() {
        return quality;
    }

    /**
     * @param value the binder to set
     */
    public void setQuality(final Quality value) {
        this.quality = value;
    }

    /**
     * @return the language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * @param value the binder to set
     */
    public void setLanguage(final Language value) {
        this.language = value;
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
        dest.writeInt(this.getId());
        dest.writeInt(this.getQuantity());
        if (this.getCard() != null
                && !this.parcelableParents.contains(this.getCard())) {
            this.getCard().writeToParcel(this.parcelableParents, dest, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
        if (this.getBinder() != null
                && !this.parcelableParents.contains(this.getBinder())) {
            this.getBinder().writeToParcel(this.parcelableParents, dest, flags);
        } else {
            dest.writeParcelable(null, flags);
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
        this.setId(parc.readInt());
        this.setQuantity(parc.readInt());
        this.setCard((Card) parc.readParcelable(Card.class.getClassLoader()));
        this.setBinder((Binder) parc.readParcelable(Binder.class.getClassLoader()));
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public Binder_Card(Parcel parc) {
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
    public static final Parcelable.Creator<Binder_Card> CREATOR
            = new Parcelable.Creator<Binder_Card>() {
        public Binder_Card createFromParcel(Parcel in) {
            return new Binder_Card(in);
        }

        public Binder_Card[] newArray(int size) {
            return new Binder_Card[size];
        }
    };

}
