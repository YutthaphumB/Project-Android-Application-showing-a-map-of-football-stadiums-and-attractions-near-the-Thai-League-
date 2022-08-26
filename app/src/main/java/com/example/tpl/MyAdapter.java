package com.example.tpl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[];
    int images[];
    Class c[] = {BgpuActivity.class, BrutdActivity.class, ButdActivity.class, ChonActivity.class, CmutdActivity.class,
            CrutdActivity.class, KkutdActivity.class, MtutdActivity.class, NpfcActivity.class, NrmfcActivity.class,
            PolfcActivity.class, PtprchActivity.class, RbmfcActivity.class, SpcActivity.class, SpfcActivity.class,
            TpfcActivity.class};
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context.getApplicationContext(), c[position]);
                context.startActivity(in);
                Toast.makeText(context.getApplicationContext(), data1[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1, myText2;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            myText1 =itemView.findViewById(R.id.txtTeam);
            myText2 =itemView.findViewById(R.id.txtStadium);
            myImage =itemView.findViewById(R.id.imglogo);

        }
    }
}
