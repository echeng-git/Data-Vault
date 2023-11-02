package com.example.sigma_blue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListAdapter extends
        RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    /* Caching the views in the adapter. */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView make;
        TextView id;

        /* Constructor that accepts the entire row */
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            make = itemView.findViewById(R.id.itemMake);
            id = itemView.findViewById(R.id.uniqueId);
        }
    }

    /* Attributes */
    private ItemList itemList;

    /* Factories and Constructors */

    public static ItemListAdapter newInstance(ItemList itemList) {
        return new ItemListAdapter(itemList);
    }

    /**
     * Basic constructor. Takes in the ItemList that will be adapted to a list view.
     * @param itemList is the ItemList object that will be displayed on lists through this adapter.
     */
    public ItemListAdapter(ItemList itemList) {
        this.itemList = itemList;
    }

    /**
     * The amount of Items that are currently held by the adapter.
     *
     * @return Count of items.
     */
    public int getCount() {
        return itemList.getCount();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    public Item getItem(int position) {
        return itemList.getItem(position);
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        /* Need to inflate the custom layout */
        View itemView = inflater.inflate(R.layout.view_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, int position) {
        /* Caching the item that will be used to fill up the row */
        Item item = itemList.getItem(position);

        /* Assigning the content of the view holder */
        TextView nameView = holder.name;
        TextView makeView = holder.make;
        TextView idView = holder.id;

        /* Setting the text of a row */
        nameView.setText(item.getName());
        makeView.setText(item.getMake());
        idView.setText(item.getSerialNumber());
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;    // TODO: Want to have HashCode for each item. We need to think about how
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return itemList.getCount();
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }
    public void addItem(Item item) {
        this.itemList.add(item);
        notifyItemChanged(itemList.size() -1);
    }
    public void removeItem(int position) {
        this.itemList.remove(position);
    }

}
