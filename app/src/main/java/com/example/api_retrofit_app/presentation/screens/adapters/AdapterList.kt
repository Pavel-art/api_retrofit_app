package com.example.api_retrofit_app.presentation.screens.adaptersimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport androidx.recyclerview.widget.DiffUtilimport androidx.recyclerview.widget.ListAdapterimport androidx.recyclerview.widget.RecyclerViewimport com.example.api_retrofit_app.Rimport com.example.api_retrofit_app.databinding.FragmentItemBindingimport com.example.api_retrofit_app.models.ItemModelItemclass AdapterList : ListAdapter<ItemModelItem, AdapterList.Holder>(Comparator()) {    class Holder(view: View) : RecyclerView.ViewHolder(view) {        private val binding = FragmentItemBinding.bind(view)        fun bind(item: ItemModelItem) = with(binding) {            tvTitle.text = item.title            //getImage(url = item.thumbnailUrl, imageView = ivImage)        }//        private fun getImage(url:String, imageView: ImageView) {//            Picasso.get()//                .load(url)//                .placeholder(R.drawable.ic_launcher_background)//                .error(R.drawable.ic_launcher_background)//                .into(imageView);//        }    }    class Comparator : DiffUtil.ItemCallback<ItemModelItem>() {        override fun areItemsTheSame(oldItem: ItemModelItem, newItem: ItemModelItem): Boolean {            return oldItem.id == newItem.id        }        override fun areContentsTheSame(oldItem: ItemModelItem, newItem: ItemModelItem): Boolean {            return oldItem == newItem        }    }    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)        return Holder(view)    }    override fun onBindViewHolder(holder: Holder, position: Int) {        holder.bind(getItem(position))    }}