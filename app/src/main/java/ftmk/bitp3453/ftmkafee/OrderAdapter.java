package ftmk.bitp3453.ftmkafee;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder>{
    private final LayoutInflater layoutInflater;
    private final Vector<OrderList> orders;

    public OrderAdapter(LayoutInflater layoutInflater, Vector<OrderList> orders) {
        this.layoutInflater = layoutInflater;
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderViewHolder(layoutInflater.inflate(R.layout.item_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.setOrder(orders.get(position));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
