/*
 * Copyright (C) 2013 Friederike Wild <friederike.wild@devmob.de>
 * Created 28.06.2013
 * 
 * https://github.com/friederikewild/DroidCustomFont
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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