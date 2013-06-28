/*
 * Copyright 2013 Friederike Wild, created 28.06.2013
 */
package de.devmob.androlib.customfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Text view that can handle custom fonts
 * 
 * @author Friederike Wild
 */
public class CustomFontTextView extends TextView
{
    /**
     * Constructor with given context. Same handling as with a TextView.
     * @param context
     */
    public CustomFontTextView(Context context)
    {
        super(context);
    }

    /**
     * Constructor with given context and attribute set.
     * @param context
     * @param attrs
     */
    public CustomFontTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        // Mark the font initialization code as not to be called when in edit mode e.g. from the interface builder.
        if(!isInEditMode())
        {
            // Fetch the given style name
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFontTextView, 0, 0);

            String fontFace = a.getString(R.styleable.CustomFontTextView_fontname);

            // TODO (fwild): Check once if available from assets folder

            // Load and assign the font typeface
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontFace);
            setTypeface(font);
            a.recycle();
        }
    }
}