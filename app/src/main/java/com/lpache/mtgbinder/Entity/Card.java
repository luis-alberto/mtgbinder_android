package com.lpache.mtgbinder.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 10/07/15.
 */
public class Card implements Serializable, Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

    private static String URL_IMAGE_TXT = "https://www.mkmapi.eu/ws/v1.1/";
    private static String URL_WEBSITE_TXT = "https://www.magiccardmarket.eu";

    private int idProduct;
    private String name_1;      //name Eng
    private String name_2;      //name Fr
    private String name_3;      //name Ger
    private String name_4;      //name Spa
    private String name_5;      //name Ita
    private String url_image;
    private String url_website;
    private double price_low;
    private double price_lowex;
    private double price_trend;
    private double price_lowfoil;
    private ArrayList<Binder_Card> bindersCards_card;

    /**
     * Default constructor.
     */
    public Card() {

    }

    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return this.idProduct;
    }

    /**
     * @param value the idProduct to set
     */
    public void setIdProduct(final int value) {
        this.idProduct = value;
    }

    /**
     * @return the name_1
     */
    public String getName_1() {
        return this.name_1;
    }

    /**
     * @param value the name_1 to set
     */
    public void setName_1(final String value) {
        this.name_1 = value;
    }

    /**
     * @return the name_2
     */
    public String getName_2() {
        return this.name_2;
    }

    /**
     * @param value the name_2 to set
     */
    public void setName_2(final String value) {
        this.name_2 = value;
    }

    /**
     * @return the name_3
     */
    public String getName_3() {
        return this.name_3;
    }

    /**
     * @param value the name_3 to set
     */
    public void setName_3(final String value) {
        this.name_3 = value;
    }

    /**
     * @return the name_4
     */
    public String getName_4() {
        return this.name_4;
    }

    /**
     * @param value the name_4 to set
     */
    public void setName_4(final String value) {
        this.name_4 = value;
    }

    /**
     * @return the name_5
     */
    public String getName_5() {
        return this.name_5;
    }

    /**
     * @param value the name_5 to set
     */
    public void setName_5(final String value) {
        this.name_5 = value;
    }

    /**
     * @return the url_image
     */
    public String getUrl_image() {
        return this.url_image;
    }

    /**
     * @param value the url_image to set
     */
    public void setUrl_image(final String value) {
        this.url_image = URL_IMAGE_TXT+value;
    }

    /**
     * @return the url_website
     */
    public String getUrl_website() {
        return this.url_website;
    }

    /**
     * @param value the url_website to set
     */
    public void setUrl_website(final String value) {
        this.url_website = URL_WEBSITE_TXT+value;
    }

    /**
     * @return the price_low
     */
    public double getPrice_low() {
        return this.price_low;
    }

    /**
     * @param value the price_low to set
     */
    public void setPrice_low(final double value) {
        this.price_low = value;
    }

    /**
     * @return the price_lowex
     */
    public double getPrice_lowex() {
        return this.price_lowex;
    }

    /**
     * @param value the price_lowex to set
     */
    public void setPrice_lowex(final double value) {
        this.price_lowex = value;
    }

    /**
     * @return the price_trend
     */
    public double getPrice_trend() {
        return this.price_trend;
    }

    /**
     * @param value the price_trend to set
     */
    public void setPrice_trend(final double value) {
        this.price_trend = value;
    }

    /**
     * @return the price_lowfoil
     */
    public double getPrice_lowfoil() {
        return this.price_lowfoil;
    }

    /**
     * @param value the price_lowfoil to set
     */
    public void setPrice_lowfoil(final double value) {
        this.price_lowfoil = value;
    }

    /**
     * @return the bindersCards_card
     */
    public ArrayList<Binder_Card> getBindersCards_card() {
        return this.bindersCards_card;
    }

    /**
     * @param value the bindersCards_card to set
     */
    public void setBindersCards_card(final ArrayList<Binder_Card> value) {
        this.bindersCards_card = value;
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
        dest.writeInt(this.getIdProduct());
        dest.writeString(this.getName_1());
        dest.writeString(this.getName_2());
        dest.writeString(this.getName_3());
        dest.writeString(this.getName_4());
        dest.writeString(this.getName_5());
        dest.writeString(this.getUrl_image());
        dest.writeString(this.getUrl_website());

        if (this.getBindersCards_card() != null) {
            dest.writeInt(this.getBindersCards_card().size());
            for (Binder_Card item : this.getBindersCards_card()) {
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
        this.setIdProduct(parc.readInt());
        this.setName_1(parc.readString());
        this.setName_2(parc.readString());
        this.setName_3(parc.readString());
        this.setName_4(parc.readString());
        this.setName_5(parc.readString());
        this.setUrl_image(parc.readString());
        this.setUrl_website(parc.readString());

        int nbBindersCards_card = parc.readInt();
        if (nbBindersCards_card > -1) {
            ArrayList<Binder_Card> items =
                    new ArrayList<Binder_Card>();
            for (int i = 0; i < nbBindersCards_card; i++) {
                items.add((Binder_Card) parc.readParcelable(
                        Binder_Card.class.getClassLoader()));
            }
            this.setBindersCards_card(items);
        }
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public Card(Parcel parc) {
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
    public static final Parcelable.Creator<Card> CREATOR
            = new Parcelable.Creator<Card>() {
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    /**
     * Name in select language.
     * @param language
     * @return name in this language
     */
    public String toString(Language language) {
        switch (language.getValue()){
            case 1: return name_1;
            case 2: return name_2;
            case 3: return name_3;
            case 4: return name_4;
            case 5: return name_5;
            default: return "";
        }
    }
}
