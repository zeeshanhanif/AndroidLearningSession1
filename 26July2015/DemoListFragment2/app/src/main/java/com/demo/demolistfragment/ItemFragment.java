package com.demo.demolistfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


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
       /* setListAdapter(new ArrayAdapter<Student>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, list ));*/

        MyCustomAdapter ca = new MyCustomAdapter(getActivity(),list);
        setListAdapter(ca);


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


    public class MyCustomAdapter extends ArrayAdapter {

        public MyCustomAdapter(Activity activity,ArrayList<Student> list){
            super(activity,0,list);
        }

        @Override
        public View getView(final int position,View convertView, ViewGroup parent){

            if(convertView==null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.my_custom_list_item, null);
            }
            Student st = (Student)getItem(position);
            TextView t1 = (TextView)convertView.findViewById(R.id.nameTextView);
            t1.setText(st.getName());

            TextView t2 = (TextView)convertView.findViewById(R.id.ageTextView);
            t2.setText(String.valueOf(st.getAge()));

            Button b1 = (Button)convertView.findViewById(R.id.button);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),"Hello Click position = "+position,Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }
    }



}
