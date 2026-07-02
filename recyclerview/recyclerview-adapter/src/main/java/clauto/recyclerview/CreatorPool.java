package com.clauto.recyclerview;

public interface CreatorPool {

    int getCreatorIndex(BaseRecyclerViewAdapter adapter, int position);
    BaseViewHolder.Creator getCreator(int index);
}
