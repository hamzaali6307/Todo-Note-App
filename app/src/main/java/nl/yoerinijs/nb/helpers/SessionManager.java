package nl.yoerinijs.nb.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Em Waqas on 6/17/2017.
 */

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "hamza";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_EMAIL = "email";
    // private static final String KEY_NAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_TOKEN = "token";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn, String email, String password) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.putString(KEY_EMAIL, email);
        // editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_PASSWORD,password);
        // editor.putString(KEY_CLASS, user.getStdclass());
        // editor.putString(KEY_ADDRESS, user.getAddress());
        // editor.putString(KEY_STATUS, user.getStatus());
        // commit changes
        editor.commit();
        Log.d( TAG, "User login session modified!");
    }
    public void setToken(String token) {
        editor.putString(KEY_TOKEN, token);
        editor.commit();
        Log.d( TAG, "token modified!");
    }
    public String getKeyToken() {
        String token = pref.getString( KEY_TOKEN, "0");
        return token;
    }

    public boolean isLoggedIn() {
        boolean isloggedIn = pref.getBoolean ( KEY_IS_LOGGED_IN,false );
        return isloggedIn;
    }
    public String getKeyUserEmail() {
        return pref.getString(KEY_EMAIL, "");
    }
    public String getKeyUserPassword() {
        return pref.getString(KEY_PASSWORD, "");
    }
}
