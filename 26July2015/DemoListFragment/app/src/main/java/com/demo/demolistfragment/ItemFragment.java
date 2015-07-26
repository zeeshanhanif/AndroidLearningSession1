package com.demo.demolistfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;




import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the
 * interface.
 */
public class ItemFragment extends ListFragment {


    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("Fardan",30));
        list.add(new Student("Sarosh",35));
        list.add(new Student("Amin",25));
        list.add(new Student("Aijaz",12));
        list.add(new Student("Aziz",50));


        // TODO: Change Adapter to display your content
        setListAdapter(new ArrayAdapter<Student>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, list ));


    }





    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        /*if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }*/
    }



}
