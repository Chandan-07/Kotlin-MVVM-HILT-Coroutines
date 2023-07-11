package com.example.codewithcb.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codewithcb.R
import com.example.codewithcb.databinding.ItemListBinding
import com.example.codewithcb.domain.models.CharacterModel

class ItemListAdapter(
    val characterModel: ArrayList<CharacterModel>,
    val listener: OnContactsItemClickedListener
) : RecyclerView.Adapter<ItemListAdapter.ItemViewBinding>() {

    val clickedListener: OnContactsItemClickedListener = listener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewBinding {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list, parent, false
        )

        return ItemViewBinding(binding)
    }

    override fun onBindViewHolder(
        holder: ItemViewBinding,
        position: Int
    ) {
        val user: CharacterModel = characterModel[position]
        holder.mBinding.tvTitle.text = user.name
        holder.mBinding.tvSubTitle.text = user.gender
        Glide.with(holder.mBinding.ivDisplay.context).load(characterModel[position].image).into(holder.mBinding.ivDisplay)
        holder.itemView.setOnClickListener {
            listener.onContactItemsClicked(user)
        }
    }

    override fun getItemCount(): Int {
        return characterModel.size
    }

    interface OnContactsItemClickedListener {
        fun onContactItemsClicked(contactModel: CharacterModel)
    }

    class ItemViewBinding(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val mBinding: ItemListBinding = binding
    }
}
