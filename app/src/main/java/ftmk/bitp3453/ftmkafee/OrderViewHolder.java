package ftmk.bitp3453.ftmkafee;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderViewHolder extends RecyclerView.ViewHolder {
//    private final TextView lblBurger1;
    private final TextView lblQtyBurger1;
//    private final TextView lblBurger2;
    private final TextView lblQtyBurger2;
//    private final TextView lblBurger3;
    private final TextView lblQtyBurger3;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
//        this.lblBurger1 = itemView.findViewById(R.id.lblBurger1);
        this.lblQtyBurger1 = itemView.findViewById(R.id.lblQtyBurger1);
//        this.lblBurger2 = itemView.findViewById(R.id.lblBurger2);
        this.lblQtyBurger2 = itemView.findViewById(R.id.lblQtyBurger2);
//        this.lblBurger3 = itemView.findViewById(R.id.lblBurger3);
        this.lblQtyBurger3 = itemView.findViewById(R.id.lblQtyBurger3);
//        this.lblBurger1 = lblBurger1;
//        this.lblQtyBurger1 = lblQtyBurger1;
//        this.lblBurger2 = lblBurger2;
//        this.lblQtyBurger2 = lblQtyBurger2;
//        this.lblBurger3 = lblBurger3;
//        this.lblQtyBurger3 = lblQtyBurger3;
    }

    public void setOrder(OrderList order) {
//        lblBurger1.setText(student.getStrBurger1());
        lblQtyBurger1.setText(order.getStrQtyBurger1());
//        lblBurger2.setText(student.getStrBurger2());
        lblQtyBurger2.setText(order.getStrQtyBurger2());
//        lblBurger3.setText(student.getStrBurger3());
        lblQtyBurger3.setText(order.getStrQtyBurger3());
    }
}
