package com.example.shaymaa.disegnnew;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import static android.view.Gravity.LEFT;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout = null;
    SearchView sv;
    private GridLayoutManager lLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        lLayout = new GridLayoutManager(MainActivity.this, 2);

        sv= (SearchView) findViewById(R.id.mSearch);
        sv.setGravity(LEFT);


         RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(linearLayoutManager);
//        rv.setLayoutManager(  new LinearLayoutManager(this, LinearLayoutManager. HORIZONTAL, true));
//         rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());


        final SectionListDataAdapter adapterr= new SectionListDataAdapter(this,getNames());

        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapterr);

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);


        my_recycler_view.setLayoutManager(lLayout);

        my_recycler_view.setAdapter(adapter);



        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Products> getPlayers()
    {
        ArrayList<Products> productses =new ArrayList<>();
        Products p=new Products();
        p.setName( "كوكا كولا");
        p.setPos("56");
        p.setImg(R.drawable.mm);
        productses.add(p);
        p=new Products();
        p.setName("شبسي");
        p.setPos("34");
        p.setImg(R.drawable.nn);
        productses.add(p);
        p=new Products();
        p.setName("بسيلاء");
        p.setPos("45");
        p.setImg(R.drawable.pr);
        productses.add(p);
        p=new Products();
        p.setName("لحوم");
        p.setPos("67");
        p.setImg(R.drawable.  ww);
        productses.add(p);
        p=new Products();
        p.setName("تونه");
        p.setPos("77");
        p.setImg(R.drawable. nn);
        productses.add(p);
        p=new Products();
        p.setName("سمك");
        p.setPos("56");
        p.setImg(R.drawable.mm);
        productses.add(p);


        Products n=new Products();
        n.setName("كوفي");
        n.setPos("34");
        n.setImg(R.drawable.  nn);
        productses.add(n);


        Products jj=new Products();
        jj.setName(" عصائر");
        jj.setPos(" 89");
        jj.setImg(R.drawable. ww);
        productses.add(jj);

        Products w=new Products();
        w.setName("أرز");
        w.setPos("89");
        w.setImg(R.drawable.  pr);
        productses.add(w);


        Products u=new Products();
        u.setName(" سكر");
        u.setPos(" 678");
        u.setImg(R.drawable.mm);
        productses.add(u);


        Products k=new Products();
        k.setName("طماطم");
        k.setPos(" 567");
        p.setImg(R.drawable.  pr);
        productses.add(k);
        return productses;
    }





    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<SingleItemModel> getNames()
    {
        ArrayList<SingleItemModel>  names =new ArrayList<>();
        SingleItemModel p=new SingleItemModel();
        p.setName("مشروبات ");
        p.setImg(R.drawable.mmmm);
        names.add(p);
        SingleItemModel n=new SingleItemModel();
        n.setName("فواكهه  و خضروات طازجه");
        n.setImg(R.drawable. vegetables);
        names.add(n);

        SingleItemModel k=new SingleItemModel();
         k.setName("فاكهه");
        k.setImg(R.drawable.peach);
        names.add(k);

        SingleItemModel m=new SingleItemModel();
        m.setName("مشروبات");
        m.setImg(R.drawable.peach);
        names.add(m);

        SingleItemModel mm=new SingleItemModel();
        mm.setName("طازج");
        mm.setImg(R.drawable.peach);
        names.add(mm);

        SingleItemModel nn=new SingleItemModel();
         nn.setName(" مجمدات");
         nn.setImg(R.drawable.peach);
        names.add(nn);

        SingleItemModel gg=new SingleItemModel();
         gg.setName("الصلطات  والحبوب والزيت ");
        gg.setImg(R.drawable.peach);
        names.add(gg);
        SingleItemModel vv=new SingleItemModel();
        vv.setName(" احتاجات المنزل  والنظافه");
        vv.setImg(R.drawable.peach);
        names.add(m);

        SingleItemModel  ff=new SingleItemModel();
        ff.setName("احتياجات الطفل");
        ff.setImg(R.drawable.peach);
        names.add(ff);

        return  names;
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
             super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
