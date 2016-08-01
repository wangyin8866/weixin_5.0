package wy.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import wy.com.myapplication.R;
import wy.com.myapplication.entity.TuiJian;

/**
 * Created by DELL on 2016/7/5.
 */
public class TuiJianAdapter extends BaseAdapter {
    private List<TuiJian> mList = null;
    private Context mContext;
    private LayoutInflater inflater;

    public TuiJianAdapter(List<TuiJian> list, Context context) {
        this.mList = list;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TuiJian tj = mList.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.tuijian_item, null);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.tuijian_icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tuijian_name);
            viewHolder.date = (TextView) convertView.findViewById(R.id.tuijian_date);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tuijian_title);
            viewHolder.content = (ImageView) convertView.findViewById(R.id.tuijian__content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (!tj.getProfile_image().equals("")) {
            Picasso.with(mContext).load(tj.getProfile_image()).placeholder(R.mipmap.ic_launcher).into(viewHolder.icon);
        }

//
//
//        Picasso.with(mContext).load(tj.getContent()).placeholder(R.mipmap.ic_launcher).into(viewHolder.content);
        viewHolder.name.setText(tj.getName());
        viewHolder.date.setText(tj.getCreated_at());
        viewHolder.title.setText(tj.getText());

        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "我点击了图像", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "title", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }


    class ViewHolder {
        ImageView icon, content;
        TextView name, date, title;
    }
}
