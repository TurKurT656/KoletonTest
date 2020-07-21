package com.example.koletontest

import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton

@Suppress("UNCHECKED_CAST")
@BindingAdapter("setData")
fun RecyclerView.setRecyclerViewData(data: List<Itemm>?) {
    data?.let {
        if (adapter is Adp) (adapter as Adp).submitList(it)
    }
}

@BindingAdapter("loadSkeleton", "skeletonLayout", "skeletonCount", requireAll = false)
fun RecyclerView.isLoading(isLoading: Boolean?, @LayoutRes itemLoadingLayout: Int?, itemCount: Int?) {
    if (isLoading == true) {
        if (itemLoadingLayout != null)
            loadSkeleton(itemLoadingLayout) {
                itemCount(itemCount ?: 4)
                color(R.color.colorAccent)
                shimmer(true)
            }
        else
            loadSkeleton()
    } else hideSkeleton()
}