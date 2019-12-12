package com.example.travelers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo !=  null && activeNetworkInfo.isConnected();
    }

    public static List<User> getUsers(){

        List<User> userList = new ArrayList<>();

        userList.add(new User("Alain",
                "Juppé",
                "15/08/1945",
                "alain.juppe@gmail.com",
                "+33 6 01 02 03 04",
                "https://resize-europe1.lanmedia.fr/r/620,310,FFFFFF,center-middle/img/var/europe1/storage/images/europe1/dossiers/alain-juppe/9880354-5-fre-FR/Alain-Juppe.jpg"));

        return userList;
    }

}
