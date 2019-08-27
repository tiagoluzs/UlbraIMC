package br.com.tiagoluzs.ulbraimc;

import android.os.Parcel;
import android.os.Parcelable;

public class IMC implements Parcelable {
    float peso;
    float altura;

    public IMC(float altura,float peso) {
        this.peso = peso;
        this.altura = altura;
    }

    protected IMC(Parcel in) {
        peso = in.readFloat();
        altura = in.readFloat();
    }

    public static final Creator<IMC> CREATOR = new Creator<IMC>() {
        @Override
        public IMC createFromParcel(Parcel in) {
            return new IMC(in);
        }

        @Override
        public IMC[] newArray(int size) {
            return new IMC[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(peso);
        parcel.writeFloat(altura);
    }
}
