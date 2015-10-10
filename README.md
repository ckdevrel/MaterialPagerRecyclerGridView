[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialPagerRecyclerGridView-green.svg?style=flat)](https://android-arsenal.com/details/3/2619)

# MaterialPagerRecyclerGridView

It is a RecyclerView using GridLayoutManager with header layout as ViewPager. This can be easily customized according to the usage. 

<a href="http://imgur.com/UOgU0AX"><img src="http://i.imgur.com/UOgU0AX.gif" title="source: imgur.com" /></a>


### **Customization**

Here I have used images for adapters and view pagers from **arrays.xml:**. You can use your own images or can even load images from the url using picasso, glide, UIL or whatever in to the adapter and view pager.

### **Images for GridItems**

Pass your images into the adapter classes as like below

```
// where R.arrays.xml are images from the drawable folder.
final MainAdapter adapter = new MainAdapter(this, R.array.icons);

```
The MainAdapter is nothing but a adapter class for RecyclerView wher you pass a images for griditems. 

### **Images for ViewPagers**

```
// I am passing the same list of images that I have used for GridItems. You can use your own instead of **mImageResID**.
ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(mContext, mImageResID);

```

The ViewPagerAdapter is a class for ViewPager and it is found inside MainAdapter.

**Note:** You can even pass ArrayList<Object> and customize your layout for the combination of both images and texts or whatever according to your requirement. I have used layout with ImageViews in this repo only for the sample purpose.

### **Points to be remember**

There are certain special aspects that must be followed before customizing your layout.

**List count:**

The list count should always be +1 (i.e)

```
 @Override
    public int getItemCount() {
        return (mContext.getResources().getIntArray(mImageResID).length) + HEADER_PAGER_LAYOUT;
    }
    
```

where **HEADER_PAGER_LAYOUT** is a static variable with value **1**

**List position:**

In order to get the exact position of the particular item in a list.

you have to -1 from the current positon(i.e)

```
@Override
    public void onClick(View view) {

        mOnGridItemSelectedListener.onGridItemClick(view,getAdapterPosition() - HEADER_PAGER_LAYOUT);
    }
    
```
where **HEADER_PAGER_LAYOUT** is a static variable with value **1**

    



