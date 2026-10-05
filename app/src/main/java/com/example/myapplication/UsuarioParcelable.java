package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioParcelable implements Parcelable {
    private String nombre;
    private String edad;
    private String correo;

    public UsuarioParcelable(String nombre, String edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    protected UsuarioParcelable(Parcel in) {
        nombre = in.readString();
        edad = in.readString();
        correo = in.readString();
    }

    public static final Creator<UsuarioParcelable> CREATOR = new Creator<UsuarioParcelable>() {
        @Override
        public UsuarioParcelable createFromParcel(Parcel in) {
            return new UsuarioParcelable(in);
        }

        @Override
        public UsuarioParcelable[] newArray(int size) {
            return new UsuarioParcelable[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(edad);
        dest.writeString(correo);
    }
}
