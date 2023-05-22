import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labrobota2.R

data class DataItem(val title: String, val description: String)

class DataListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DataAdapter
    private lateinit var dataItems: List<DataItem>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_data_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        dataItems = createDataItems()
        adapter = DataAdapter(dataItems) { item ->
            navigateToDetailFragment(item)
        }
        recyclerView.adapter = adapter
        return view
    }

    private fun navigateToDetailFragment(item: DataItem) {
        val action = DataListFragmentDirections.actionDataListFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }


    private fun createDataItems(): List<DataItem> {
        val dataItems = mutableListOf<DataItem>()
        // Horror film data
        dataItems.add(DataItem("The Haunting Hour", "In a small town plagued by a series of unexplained deaths, a group of teenagers discovers an ancient curse tied to a haunted hour that repeats itself every night. As they unravel the dark secret behind the curse, they must confront vengeful spirits and fight for their survival before time runs out."))
        dataItems.add(DataItem("Crimson Shadows", "A group of college friends embark on a road trip to a secluded cabin in the woods for a weekend getaway. However, they soon find themselves hunted by a mysterious creature that lurks within the shadows. As tension rises and friendships are tested, they must uncover the creature's origins and find a way to escape its deadly grasp."))
        dataItems.add(DataItem("The Dollmaker's Legacy", "A family moves into an old Victorian house, unaware of its dark past. When their daughter discovers a collection of eerie dolls hidden in the attic, she unknowingly awakens an ancient evil. As the dolls come to life, terror ensues, and the family must unravel the dollmaker's twisted legacy before they become trapped forever."))
        dataItems.add(DataItem("Whispering Echoes", "In a remote mountain village, a group of unsuspecting tourists checks into an eerie inn rumored to be haunted. As night falls, they are tormented by malevolent spirits that whisper secrets from their past, driving them to madness. With their own demons resurfacing, they must confront their darkest fears to break free from the inn's spectral grip."))
        dataItems.add(DataItem("The Abandoned Asylum", "A journalist and her cameraman investigate the remains of an abandoned asylum with a notorious past. As they explore the decaying halls, they encounter vengeful spirits and uncover a sinister conspiracy surrounding the asylum's dark experiments. With their sanity on the line, they must escape the clutches of the asylum before becoming permanent residents of its haunted corridors."))
        return dataItems
    }
}

class DataAdapter(private val dataItems: List<DataItem>, private val onItemClick: (DataItem) -> Unit) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataItems[position]
        holder.itemView.setOnClickListener { onItemClick(dataItem) }
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }
}
