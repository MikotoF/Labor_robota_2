// DetailFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private lateinit var textViewTitle: TextView
    private lateinit var imageViewImage: ImageView
    private lateinit var item: DataItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textViewTitle = view.findViewById(R.id.textViewTitle)
        imageViewImage = view.findViewById(R.id.imageViewImage)

        arguments?.let {
            item = DetailFragmentArgs.fromBundle(it).item
            populateData()
        }

        return view
    }

    private fun populateData() {
        textViewTitle.text = item.title
        Glide.with(requireContext())
            .load(item.imageUrl)
            .into(imageViewImage)
    }
}
