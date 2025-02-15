package co.edu.upb.pdfconverter;

import java.util.ArrayList;
import java.util.Arrays;

public class UrlRepository {

    public final ArrayList<UrlType> UrlTypes = new ArrayList<UrlType>();

    public void SetUrlType() {

        UrlType[] urlTypesArray = {
            new UrlType("https://co.pinterest.com/pin/653022014998039661/", "Alhaitham-Cat"),
            new UrlType("https://www.velez.com.co/chaqueta-1036354-40/p", "Velez-chaqueta-morada"),
            new UrlType("https://www.velez.com.co/chaqueta-1037745-00/p", "Velez-chaqueta-cuero"),
            new UrlType("https://www.velez.com.co/chaqueta-1036570-02/p", "Velez-chaqueta-cuero-miel"),
            new UrlType("https://www.velez.com.co/manos-libres-1038726-28/p", "bolso-bordado-peces"),
            // Replacing Amazon links with Unsplash animal images:
            new UrlType("https://unsplash.com/photos/NodtnCsLdTE", "Unsplash Lion"),
            new UrlType("https://unsplash.com/photos/XTQxQ-gWffI", "Unsplash Elephant"),
            new UrlType("https://unsplash.com/photos/AdK6DlXhMdE", "Unsplash Giraffe"),
            new UrlType("https://unsplash.com/photos/ybHtBdrF3VY", "Unsplash Tiger"),
            new UrlType("https://unsplash.com/photos/mEZ3PoFGs_k", "Unsplash Bear"),
            new UrlType("https://unsplash.com/photos/H0kWfYkq9pM", "Unsplash Wolf"),
            new UrlType("https://unsplash.com/photos/gMsnXqILjp4", "Unsplash Fox"),
            new UrlType("https://unsplash.com/photos/7KHCNCddn2U", "Unsplash Bird"),
            new UrlType("https://unsplash.com/photos/-9CUBw2y4lA", "Unsplash Parrot"),
            new UrlType("https://unsplash.com/photos/2EGNqazbAMk", "Unsplash Penguin"),
            new UrlType("https://unsplash.com/photos/ewb0RBK0xW0", "Unsplash Dolphin"),
            new UrlType("https://unsplash.com/photos/WLxQvbMyfas", "Unsplash Whale"),
            new UrlType("https://unsplash.com/photos/1k9T5YiZ2WU", "Unsplash Sea Turtle"),
            new UrlType("https://unsplash.com/photos/3Z70SDuYs5g", "Unsplash Horse"),
            new UrlType("https://unsplash.com/photos/lrQPTQs7nQQ", "Unsplash Cow"),
            new UrlType("https://unsplash.com/photos/5NLCaz2wJXE", "Unsplash Pig"),
            new UrlType("https://unsplash.com/photos/JmuyB_LibRo", "Unsplash Sheep"),
            new UrlType("https://unsplash.com/photos/DSI5t0W2jpc", "Unsplash Goat"),
            new UrlType("https://unsplash.com/photos/_dH-oQF9w-Y", "Unsplash Camel"),
            new UrlType("https://unsplash.com/photos/I1U4pwCZ7tA", "Unsplash Llama"),
            new UrlType("https://unsplash.com/photos/UEeHKQ1IrsY", "Unsplash Kangaroo"),
            new UrlType("https://unsplash.com/photos/PeFKQpokJk0", "Unsplash Koala"),
            new UrlType("https://unsplash.com/photos/sibVwORYqs0", "Unsplash Sloth"),
            new UrlType("https://unsplash.com/photos/SGgY8O01i9s", "Unsplash Deer"),
            new UrlType("https://unsplash.com/photos/3TLl_97HNJo", "Unsplash Owl"),
            new UrlType("https://unsplash.com/photos/5QgIuuBxKwM", "Unsplash Rabbit"),
            new UrlType("https://unsplash.com/photos/2d4lAQAlbDA", "Unsplash Hedgehog")
        };

        this.UrlTypes.addAll(Arrays.asList(urlTypesArray));
    }
}
