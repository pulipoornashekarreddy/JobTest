package in.net.foru.www.jobtest;

import android.annotation.SuppressLint;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.provider.ContactsContract.Contacts;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by poornashekarreddy.p on 24-03-2018.
 */

public class Tab3 extends ListFragment {


    ListView lv;
    Cursor courser1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabc, container, false);//here


            ContentResolver cv=getActivity().getContentResolver();
            courser1 = cv.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            getActivity().startManagingCursor(courser1);
            String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};
            int[] to = {android.R.id.text1,android.R.id.text2};
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(getContext(),android.R.layout.simple_list_item_2,courser1,from,to);
            setListAdapter(listAdapter);
            /*lv=getListView();
            lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);*/
            //Toast.makeText(getContext(),"hi",Toast.LENGTH_LONG).show();

        return rootView;
    }


}
