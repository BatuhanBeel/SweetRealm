package com.example.sweetrealm.data.repository

import com.example.sweetrealm.R
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCategory

val sweetCategories = listOf(
    SweetCategory(id = 1, name = "Cakes", imageId = R.drawable.cake_category),
    SweetCategory(id = 2, name = "Cheesecake", imageId = R.drawable.cheesecake_category),
    SweetCategory(id = 3, name = "Cookies and Biscuits", imageId =R.drawable.cookies_and_biscuits_category),
    SweetCategory(id = 4, name = "Chocolate Desserts", imageId = R.drawable.chocolate_category),
    SweetCategory(id = 5, name = "Pancakes and Waffles", imageId = R.drawable.pancake_and_waffle_category),
    SweetCategory(id = 6, name = "Pies and Tarts", imageId = R.drawable.pies_and_tarts_category),
    SweetCategory(id = 7, name = "Puddings", imageId = R.drawable.puddings_category),
    SweetCategory(id = 8, name = "Miscellaneous", imageId = R.drawable.miscellaneous_category),
)

val sweets = listOf(
    Sweet(
        name = "Battenberg Cake",
        imageUrl = "https://www.themealdb.com/images/media/meals/ywwrsp1511720277.jpg",
        price = 3f,
        category = "Cakes",
        country = "British",
        ingredients = "Apricot, Marzipan, Vanilla Extract, Almond Extract",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Tunisian Orange Cake",
        imageUrl = "https://www.themealdb.com/images/media/meals/y4jpgq1560459207.jpg",
        price = 3.5f,
        category = "Cakes",
        country = "Tunisian",
        ingredients = "Orange, Vanilla Extract, Caster Sugar, Olive Oil, Baking Powder, Eggs",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Carrot Cake",
        imageUrl = "https://www.themealdb.com/images/media/meals/vrspxv1511722107.jpg",
        price = 4.5f,
        category = "Cakes",
        country = "British",
        ingredients = "Cinnamon, Carrots, Walnuts, Cream Cheese, Bicarbonate Of Soda",
        isFavorite = true,
        isNew = false
    ),
    Sweet(
        name = "Dundee Cake",
        imageUrl = "https://www.themealdb.com/images/media/meals/wxyvqq1511723401.jpg",
        price = 3f,
        category = "Cakes",
        country = "British cheesecake with a graham cracker crust.",
        ingredients = "Almonds, Orange, Apricot Jam, Dried Fruit, Glace Cherry",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Christmas Cake",
        imageUrl = "https://www.themealdb.com/images/media/meals/ldnrm91576791881.jpg",
        price = 3.5f,
        category = "Cakes",
        country = "British",
        ingredients = "Ground Almonds, Sherry, Candied Peel, Glace Cherry, Lemon, Vanilla Extract",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Honey Yogurt Cheesecake",
        imageUrl = "https://www.themealdb.com/images/media/meals/y2irzl1585563479.jpg",
        price = 3.5f,
        category = "Cheesecake",
        country = "Greek",
        ingredients = "Almonds, Greek Yogurt, Mascarpone, Lemon, Orange, Honey, Fruit Mix",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "New York Cheesecake",
        imageUrl = "https://www.themealdb.com/images/media/meals/swttys1511385853.jpg",
        price = 3.5f,
        category = "Cheesecake",
        country = "American",
        ingredients = "Sour Cream, Lemon Juice, Cream Cheese",
        isFavorite = true,
        isNew = false
    ),
    Sweet(
        name = "Peanut Butter Cheesecake",
        imageUrl = "https://www.themealdb.com/images/media/meals/qtuuys1511387068.jpg",
        price = 5f,
        category = "Cheesecake",
        country = "American",
        ingredients = "Peanut Cookies, Gelatine Leafs, Ricotta, Peanut Butter, Golden Syrup",
        isFavorite = true,
        isNew = false
    ),
    Sweet(
        name = "Salted Caramel Cheescake",
        imageUrl = "https://www.themealdb.com/images/media/meals/xqrwyr1511133646.jpg",
        price = 5f,
        category = "Cheesecake",
        country = "American",
        ingredients = "Vanilla Extract, Caramel, Sea Salt, Toffee Popcorn, Cream Cheese, Digestive Biscuits",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Choc Chip Pecan Pie",
        imageUrl = "https://www.themealdb.com/images/media/meals/rqvwxt1511384809.jpg",
        price = 4f,
        category = "Pies and Tarts",
        country = "American",
        ingredients = "Maple Syrup, Vanilla Extract, Pecan Nuts, Dark Chocolate Chips",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Key Lime Pie",
        imageUrl = "https://www.themealdb.com/images/media/meals/qpqtuu1511386216.jpg",
        price = 3.5f,
        category = "Pies and Tarts",
        country = "American",
        ingredients = "Digestive Biscuits, Condensed Milk, Lime, Double Cream",
        isFavorite = true,
        isNew = false
    ),
    Sweet(
        name = "Pumpkin Pie",
        imageUrl = "https://www.themealdb.com/images/media/meals/usuqtp1511385394.jpg",
        price = 3.5f,
        category = "Pies and Tarts",
        country = "American",
        ingredients = "Pumpkin, Nutmeg, Shortcrust Pastry",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Apple Frangipan Tart",
        imageUrl = "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg",
        price = 3f,
        category = "Pies and Tarts",
        country = "British",
        ingredients = "Bramley Apples, Butter, Ground Almonds, Almond Extract, Digestive Biscuits",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Bakewell Tart",
        imageUrl = "https://www.themealdb.com/images/media/meals/wyrqqq1468233628.jpg",
        price = 3f,
        category = "Pies and Tarts",
        country = "British",
        ingredients = "Raspberry Jam, Butter, Chilled Butter, Almond Extract, Flaked Almonds",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Canadian Butter Tarts",
        imageUrl = "https://www.themealdb.com/images/media/meals/wpputp1511812960.jpg",
        price = 2.5f,
        category = "Pies and Tarts",
        country = "Canadian",
        ingredients = "Shortcrust Pastry, Raisins, Vanilla Extract, Single Cream, Walnuts",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Chinon Apple Tarts",
        imageUrl = "https://www.themealdb.com/images/media/meals/qtqwwu1511792650.jpg",
        price = 3f,
        category = "Pies and Tarts",
        country = "French",
        ingredients = "Puff Pastry, Braeburn Apples, Red Wine Jelly, Creme Fraiche, Cardamom",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Treacle Tart",
        imageUrl = "https://www.themealdb.com/images/media/meals/wprvrw1511641295.jpg",
        price = 3f,
        category = "Pies and Tarts",
        country = "British",
        ingredients = "Golden Syrup, Lemons, Breadcrumbs, Eggs, Plain Flour, Butter",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Sugar Pie",
        imageUrl = "https://www.themealdb.com/images/media/meals/yrstur1511816601.jpg",
        price = 3.5f,
        category = "Pies and Tarts",
        country = "Canadian",
        ingredients = "Vanilla Extract, Eggs, Salt, Milk, Brown Sugar, Butter",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Classic Christmas Pudding",
        imageUrl = "https://www.themealdb.com/images/media/meals/1d85821576790598.jpg",
        price = 3f,
        category = "Puddings",
        country = "British",
        ingredients = "Almonds, Bramley Apples, Candied Peel, Nutmeg, Raisins, Breadcrumbs",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Christmas Pudding Trifle",
        imageUrl = "https://www.themealdb.com/images/media/meals/r33cud1576791081.jpg",
        price = 4f,
        category = "Puddings",
        country = "British",
        ingredients = "Orange, Grand Marnier, Custard, Flaked Almonds, Dark Chocolate",
        isFavorite = true,
        isNew = false
    ),
    Sweet(
        name = "Sticky Toffee Pudding",
        imageUrl = "https://www.themealdb.com/images/media/meals/xqqqtu1511637379.jpg",
        price = 3.5f,
        category = "Puddings",
        country = "British",
        ingredients = "Black Treacle, Muscovado Sugar, Vanilla Extract, Bicarbonate Of Soda",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Summer Pudding",
        imageUrl = "https://www.themealdb.com/images/media/meals/rsqwus1511640214.jpg",
        price = 3.5f,
        category = "Puddings",
        country = "British",
        ingredients = "Strawberries, Blackberries, Redcurrants, Raspberries",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Budino Di Ricotta",
        imageUrl = "https://www.themealdb.com/images/media/meals/1549542877.jpg",
        price = 2.5f,
        category = "Puddings",
        country = "Italian",
        ingredients = "Ricotta, Eggs, Cinnamon, Lemons, Dark Rum",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Apam balik",
        imageUrl = "https://www.themealdb.com/images/media/meals/adxcbq1619787919.jpg",
        price = 2.5f,
        category = "Pancakes and Waffles",
        country = "Malaysian",
        ingredients = "Peanut Butter, Milk, Oil, Eggs, Flour, Baking Powder, Sugar",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Banana Pancakes",
        imageUrl = "https://www.themealdb.com/images/media/meals/sywswr1511383814.jpg",
        price = 3.5f,
        category = "Pancakes and Waffles",
        country = "American",
        ingredients = "Banana, Milk, Oil, Eggs, Raspberries, Baking Powder, Vanilla Extract",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Pancakes",
        imageUrl = "https://www.themealdb.com/images/media/meals/rwuyqx1511383174.jpg",
        price = 2.5f,
        category = "Pancakes and Waffles",
        country = "American",
        ingredients = "Raspberries, Milk, Sunflower Oil, Eggs, Blueberries, Flour",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Cashew Ghoriba Biscuits",
        imageUrl = "https://www.themealdb.com/images/media/meals/t3r3ka1560461972.jpg",
        price = 2.5f,
        category = "Cookies and Biscuits",
        country = "Tunisian",
        ingredients = " Cashew Nuts, Icing Sugar, Orange Blossom Water, Almonds, Egg Yolks",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Chelsea Buns",
        imageUrl = "https://www.themealdb.com/images/media/meals/vqpwrv1511723001.jpg",
        price = 2.5f,
        category = "Cookies and Biscuits",
        country = "British",
        ingredients = "Yeast, Brown Sugar, Dried Fruit, Cinnamon, Milk, Eggs",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Peanut Butter Cookies",
        imageUrl = "https://www.themealdb.com/images/media/meals/1544384070.jpg",
        price = 3.5f,
        category = "Cookies and Biscuits",
        country = "American",
        ingredients = "Peanut Butter, Sugar, Egg",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Rogaliki",
        imageUrl = "https://www.themealdb.com/images/media/meals/7mxnzz1593350801.jpg",
        price = 3f,
        category = "Cookies and Biscuits",
        country = "Polish",
        ingredients = "Butter, Egg Yolks, Cream Cheese, Baking Powder, Flour, Jam",
        isFavorite = false,
        isNew = false
    ),

    Sweet(
        name = "Chocolate Avocado Mousse",
        imageUrl = "https://www.themealdb.com/images/media/meals/uttuxy1511382180.jpg",
        price = 3f,
        category = "Chocolate Desserts",
        country = "British",
        ingredients = "Banana, Cacao, Avocado, Honey, Lemon Juice, Vanilla, Sea Salt",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Chocolate Caramel Crispy",
        imageUrl = "https://www.themealdb.com/images/media/meals/1550442508.jpg",
        price = 3.5f,
        category = "Chocolate Desserts",
        country = "British",
        ingredients = "Mars Bar, Butter, Rice Krispies, Milk Chocolate",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Chocolate Gateau",
        imageUrl = "https://www.themealdb.com/images/media/meals/tqtywx1468317395.jpg",
        price = 2.5f,
        category = "Chocolate Desserts",
        country = "French",
        ingredients = "Plain chocolate, Butter, Milk, Eggs, Granulated Sugar, Flour",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Chocolate Raspberry Brownies",
        imageUrl = "https://www.themealdb.com/images/media/meals/yypvst1511386427.jpg",
        price = 3.5f,
        category = "Chocolate Desserts",
        country = "American",
        ingredients = "Dark Chocolate, Milk Chocolate, Salted Butter, Light Brown Soft Sugar, Cocoa, Raspberries",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Chocolate Souffle",
        imageUrl = "https://www.themealdb.com/images/media/meals/twspvx1511784937.jpg",
        price = 3.5f,
        category = "Chocolate Desserts",
        country = "French",
        ingredients = "Dark Chocolate, Caster Sugar, Eggs, Double Cream, Butter",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Rocky Road Fudge",
        imageUrl = "https://www.themealdb.com/images/media/meals/vtxyxv1483567157.jpg",
        price = 4f,
        category = "Chocolate Desserts",
        country = "American",
        ingredients = "Miniature Marshmallows, Chocolate Chips, Peanut Butter, Vanilla Extract, Peanuts",
        isFavorite = true,
        isNew = false
    ),

    Sweet(
        name = "Eton Mess",
        imageUrl = "https://www.themealdb.com/images/media/meals/uuxwvq1483907861.jpg",
        price = 5f,
        category = "Miscellaneous",
        country = "British",
        ingredients = "Strawberries, Double Cream, Meringue Nests, Ginger Cordial, Mint",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Strawberries Romanoff",
        imageUrl = "https://www.themealdb.com/images/media/meals/oe8rg51699014028.jpg",
        price = 3f,
        category = "Miscellaneous",
        country = "Russian",
        ingredients = "Strawberries, Sugar, Grand Marnier, Cream, Sour Cream",
        isFavorite = false,
        isNew = true
    ),
    Sweet(
        name = "Timbits",
        imageUrl = "https://www.themealdb.com/images/media/meals/txsupu1511815755.jpg",
        price = 2.5f,
        category = "Miscellaneous",
        country = "Canadian",
        ingredients = "Baking Powder, Salt, Flour, Sugar, Milk, Oil",
        isFavorite = false,
        isNew = false
    ),
    Sweet(
        name = "Blackberry Fool",
        imageUrl = "https://www.themealdb.com/images/media/meals/rpvptu1511641092.jpg",
        price = 4.5f,
        category = "Miscellaneous",
        country = "British",
        ingredients = "Hazelnuts, Lemon, Blackberry's, Yogurt, Raspberries, Baking Powder, Double Cream",
        isFavorite = true,
        isNew = false
    )
)
