package com.enggemy22.sherpoproject.splash.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.enggemy22.sherpoproject.R;
import com.enggemy22.sherpoproject.splash.model.PersonalModel;

import java.util.List;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.PersonalViewHolder> {
    List<PersonalModel> mlist;
    Context mcontext;
    OnItemClick itemClick;

    public PersonalAdapter(List<PersonalModel> mlist, Context mcontext, OnItemClick itemClick) {
        this.mlist = mlist;
        this.mcontext = mcontext;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public PersonalAdapter.PersonalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.personal_items, parent, false);
        PersonalViewHolder viewHolder = new PersonalViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalAdapter.PersonalViewHolder holder, int position) {
        PersonalModel model = mlist.get(position);
        holder.textDescreprion.setText(model.getDescreption());
        holder.textPrice.setText(model.getPrice());
        Glide.with(mcontext).load(model.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public class PersonalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textDescreprion, textPrice;
        Button button;

        public PersonalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textDescreprion = itemView.findViewById(R.id.textView1);
            textPrice = itemView.findViewById(R.id.textView2);
            button = itemView.findViewById(R.id.Button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        itemClick.OnButtonClick(pos);
                    }
                }
            });

        }
    }


    public interface OnItemClick {
        void OnButtonClick(int posistion);
    }
}
