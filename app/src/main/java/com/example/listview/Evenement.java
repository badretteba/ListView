package com.example.listview;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Evenement implements Parcelable {
    String titre;
    String discription;
    int eventImage;

    public Evenement(String titre, String discription,  int eventImage) {
        this.titre = titre;
        this.discription = discription;
        this.eventImage= eventImage;
    }

    protected Evenement(Parcel in) {
        titre = in.readString();
        discription = in.readString();
        eventImage = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titre);
        dest.writeString(discription);
        dest.writeInt(eventImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Evenement> CREATOR = new Creator<Evenement>() {
        @Override
        public Evenement createFromParcel(Parcel in) {
            return new Evenement(in);
        }

        @Override
        public Evenement[] newArray(int size) {
            return new Evenement[size];
        }
    };

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public String getDiscription() {
        return discription;
    }


    public void setDiscription(String discription) {
        this.discription = discription;
    }



    public int getEventImage() {
        return eventImage;
    }

    public void setEventImage(int eventImage) {
        this.eventImage = eventImage;
    }
}
