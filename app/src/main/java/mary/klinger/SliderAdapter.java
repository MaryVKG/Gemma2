package mary.klinger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;

    }

    private int titles[] = {
            R.string.first_slide_tittle,
            R.string.second_slide_tittle,
            R.string.third_slide_tittle,
            R.string.four_slide_tittle,
            R.string.five_slide_tittle


    };

    private int descriptions[] = {
            R.string.description1,
            R.string.description2,
            R.string.description3,
            R.string.description4,
            R.string.description5
    };

    private int images[] = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slides_layout, container, false);

        ImageView imageView = v.findViewById(R.id.slider_image);
        TextView heading = v.findViewById(R.id.slider_heading);
        TextView desc = v.findViewById(R.id.slider_desc);


        imageView.setImageResource(images[position]);
        heading.setText(titles[position]);
        desc.setText(descriptions[position]);


        container.addView(v);
        return v;
    }

}
