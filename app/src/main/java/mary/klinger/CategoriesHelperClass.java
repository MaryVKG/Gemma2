package mary.klinger;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
        GradientDrawable gradientDrawable;
        int image;
        String title, description;

        public CategoriesHelperClass(GradientDrawable gradientDrawable, int image, String title, String description) {
            this.gradientDrawable = gradientDrawable;
            this.image = image;
            this.title = title;
            this.description = description;
        }

    public CategoriesHelperClass(GradientDrawable gradient2, int cardone, String education) {
    }

    public int getImage() {
            return image;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public GradientDrawable getGradientDrawable() {
        return gradientDrawable;
    }


}