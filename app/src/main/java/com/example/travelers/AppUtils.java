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
                "+33 601020304",
                "https://www.bordeaux.fr/images/ebx/fr/eluCM/1730/format4/cJUPPE_1.jpg"));

        return userList;
    }

}
