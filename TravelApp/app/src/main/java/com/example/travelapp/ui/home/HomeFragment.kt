package com.example.travelapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.base.BaseFragment
import com.example.travelapp.data.Attraction
import com.example.travelapp.data.Location
import com.example.travelapp.databinding.FragmentHomeBinding
import com.example.travelapp.ui.home.adapter.HomeFragmentAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initViews() {
        // TODO: get position
        val homeFragmentAdapter = HomeFragmentAdapter {
            findNavController().navigate(
                HomeFragmentDirections.toDetailFragment("1")
            )
        }
        // TODO: convert raw json
        homeFragmentAdapter.setData(
            arrayListOf(
                Attraction(
                    title = "Sali",
                    description = "Sali is a village and a municipality in Croatia in the Zadar County. Sali is a " +
                            "small town but still the largest on the island of Dugi otok. The total population of Sali is 1,698 inhabitants.",
                    facts = arrayListOf(
                        "Largest town on the island of Dugi Otok, though it is small enough for everyone to know each other.",
                        "It is a fishing village that hosts a traditional “festa” or festival every year to honor fishermen traditions, drawing in tourists from all over Europe.",
                        "The Dalmatian breed of dogs is from the same region of Croatia, known as “Dalmatia.”",
                        "Borders two beautiful national parks, Telascica and Kornati."
                    ),
                    id = "687a58ab-1d73-4d4a-beae-68516b948fd7",
                    imageUrls = listOf(
                        "https://www.croatiaholidays.travel/storage/destinations/129311392_l-2_thumb_1150.jpg",
                        "https://cf.bstatic.com/images/hotel/max1024x768/151/151133086.jpg",
                        "https://i.croatiaimages.com/places/323/dalmatia-dugi-otok-sali-croatia-1-720x480.jpg",
                        "https://www.apartmanisostaric.com/images/slider1.jpg"
                    ),
                    location = Location(
                        latitude = "43.937887",
                        longitude = "15.163208"
                    ),
                    monthsToVisit = "June - September",
                ),
                Attraction(
                    title = "Sali2",
                    description = "Sali is a village and a municipality in Croatia in the Zadar County. Sali is a " +
                            "small town but still the largest on the island of Dugi otok. The total population of Sali is 1,698 inhabitants.",
                    facts = arrayListOf(
                        "Largest town on the island of Dugi Otok, though it is small enough for everyone to know each other.",
                        "It is a fishing village that hosts a traditional “festa” or festival every year to honor fishermen traditions, drawing in tourists from all over Europe.",
                        "The Dalmatian breed of dogs is from the same region of Croatia, known as “Dalmatia.”",
                        "Borders two beautiful national parks, Telascica and Kornati."
                    ),
                    id = "687a58ab-1d73-4d4a-beae-68516b948fd7",
                    imageUrls = listOf(
                        "https://www.croatiaholidays.travel/storage/destinations/129311392_l-2_thumb_1150.jpg",
                        "https://cf.bstatic.com/images/hotel/max1024x768/151/151133086.jpg",
                        "https://i.croatiaimages.com/places/323/dalmatia-dugi-otok-sali-croatia-1-720x480.jpg",
                        "https://www.apartmanisostaric.com/images/slider1.jpg"
                    ),
                    location = Location(
                        latitude = "43.937887",
                        longitude = "15.163208"
                    ),
                    monthsToVisit = "June - September",
                ),
                Attraction(
                    title = "Sali3",
                    description = "Sali is a village and a municipality in Croatia in the Zadar County. Sali is a " +
                            "small town but still the largest on the island of Dugi otok. The total population of Sali is 1,698 inhabitants.",
                    facts = arrayListOf(
                        "Largest town on the island of Dugi Otok, though it is small enough for everyone to know each other.",
                        "It is a fishing village that hosts a traditional “festa” or festival every year to honor fishermen traditions, drawing in tourists from all over Europe.",
                        "The Dalmatian breed of dogs is from the same region of Croatia, known as “Dalmatia.”",
                        "Borders two beautiful national parks, Telascica and Kornati."
                    ),
                    id = "687a58ab-1d73-4d4a-beae-68516b948fd7",
                    imageUrls = listOf(
                        "https://www.croatiaholidays.travel/storage/destinations/129311392_l-2_thumb_1150.jpg",
                        "https://cf.bstatic.com/images/hotel/max1024x768/151/151133086.jpg",
                        "https://i.croatiaimages.com/places/323/dalmatia-dugi-otok-sali-croatia-1-720x480.jpg",
                        "https://www.apartmanisostaric.com/images/slider1.jpg"
                    ),
                    location = Location(
                        latitude = "43.937887",
                        longitude = "15.163208"
                    ),
                    monthsToVisit = "June - September",
                ),
                Attraction(
                    title = "Sali4",
                    description = "Sali is a village and a municipality in Croatia in the Zadar County. Sali is a " +
                            "small town but still the largest on the island of Dugi otok. The total population of Sali is 1,698 inhabitants.",
                    facts = arrayListOf(
                        "Largest town on the island of Dugi Otok, though it is small enough for everyone to know each other.",
                        "It is a fishing village that hosts a traditional “festa” or festival every year to honor fishermen traditions, drawing in tourists from all over Europe.",
                        "The Dalmatian breed of dogs is from the same region of Croatia, known as “Dalmatia.”",
                        "Borders two beautiful national parks, Telascica and Kornati."
                    ),
                    id = "687a58ab-1d73-4d4a-beae-68516b948fd7",
                    imageUrls = listOf(
                        "https://www.croatiaholidays.travel/storage/destinations/129311392_l-2_thumb_1150.jpg",
                        "https://cf.bstatic.com/images/hotel/max1024x768/151/151133086.jpg",
                        "https://i.croatiaimages.com/places/323/dalmatia-dugi-otok-sali-croatia-1-720x480.jpg",
                        "https://www.apartmanisostaric.com/images/slider1.jpg"
                    ),
                    location = Location(
                        latitude = "43.937887",
                        longitude = "15.163208"
                    ),
                    monthsToVisit = "June - September",
                )
            )
        )

        val rv = binding.rvAttraction
        rv.adapter = homeFragmentAdapter
        rv.layoutManager = LinearLayoutManager(context)

    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)


}