package news.agoda.com.sample.adapters

import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import news.agoda.com.sample.R
import news.agoda.com.sample.databinding.ListItemNewsBinding
import news.agoda.com.sample.viewmodel.News

class NewsAdapter(val newsList: MutableList<News>
                  , val layoutId: Int, val requestManager: RequestManager) : CustomRecyclerView<News, ListItemNewsBinding>(newsList, layoutId) {

    override fun onBindView(stateBinding: ListItemNewsBinding?, position: Int) {

        stateBinding?.newsModel = dataList.get(position)
        requestManager
                .load(dataList.get(position).thumbUrl)
                .apply(RequestOptions().placeholder(R.drawable.place_holder))
                .into(stateBinding?.newsItemImage!!)


    }
}