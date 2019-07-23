package com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasedatabase.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Profile> profiles;

    public MyAdapter(Context c,ArrayList<Profile> p)
    {
        context=c;
        profiles=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(profiles.get(position).getName());
        holder.email.setText(profiles.get(position).getEmail());
       Picasso.get().load(String.valueOf(profiles.get(position).getProfilePic())).into(holder.profilePic);
        if (profiles.get(position).getPermission()) {
            holder.btn.setVisibility(View.VISIBLE);
            holder.onClick(position);
        }
    }
    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,email;
        ImageView profilePic;
        Button btn;
         public MyViewHolder(View itemView) {
             super(itemView);
             name=(TextView)itemView.findViewById(R.id.name);
             email=(TextView)itemView.findViewById(R.id.email);
             btn=(Button)itemView.findViewById(R.id.checkDetails);
             profilePic=(ImageView)itemView.findViewById(R.id.profilePic);

         }
         public void onClick(final int position)
         {
           btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context, "user"+position+"is clicked", Toast.LENGTH_SHORT).show();
               }
           });
         }
     }
}
