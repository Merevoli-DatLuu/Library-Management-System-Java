package librarymanagementsystem.GUI.Table;

import java.util.List;

public interface PaginationDataProvider<T> {
    int getTotalRowCount();

    List<T> getRows(int startIndex, int endIndex,
                    int sortColumnIndex, boolean sortDescending);
}