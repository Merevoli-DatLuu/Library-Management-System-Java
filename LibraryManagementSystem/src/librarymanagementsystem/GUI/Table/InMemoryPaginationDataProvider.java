package librarymanagementsystem.GUI.Table;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InMemoryPaginationDataProvider<T> implements PaginationDataProvider<T> {
    private SortInfo currentSortInfo;
    private InMemoryComparator<T> comparator;
    private final List<T> rows;

    public InMemoryPaginationDataProvider(List<T> rows, ObjectTableModel<T> objectTableModel) {
        this.rows = rows;
        currentSortInfo = new SortInfo();
        comparator = new InMemoryComparator(currentSortInfo, objectTableModel);
    }

    @Override
    public int getTotalRowCount() {
        return rows.size();
    }

    @Override
    public List<T> getRows(int startIndex, int endIndex, int sortColumnIndex, boolean sortDescending) {
        sort(sortColumnIndex, sortDescending);
        return rows.subList(startIndex, endIndex);
    }

    private void sort(int sortColumnIndex, boolean sortDescending) {
        if (!currentSortInfo.equals(sortColumnIndex, sortDescending)) {
            currentSortInfo.sortIndex = sortColumnIndex;
            currentSortInfo.sortDescending = sortDescending;
            Collections.sort(rows, comparator);
        }
    }

    private static class SortInfo {
        private int sortIndex = -1;
        private boolean sortDescending;

        boolean equals(int sortIndex, boolean sortDescending) {
            return sortIndex == this.sortIndex &&
                    sortDescending == this.sortDescending;
        }
    }

    private static class InMemoryComparator<T> implements Comparator<T> {
        private final SortInfo sortInfo;
        private ObjectTableModel<T> objectTableModel;

        private InMemoryComparator(SortInfo sortInfo, ObjectTableModel<T> objectTableModel) {
            this.sortInfo = sortInfo;
            this.objectTableModel = objectTableModel;
        }

        @Override
        public int compare(T e1, T e2) {
            Object v1 = objectTableModel.getValueAt(e1, sortInfo.sortIndex);
            Object v2 = objectTableModel.getValueAt(e2, sortInfo.sortIndex);
            if (v1 instanceof Comparable && v2 instanceof Comparable) {
                return sortInfo.sortDescending ? ((Comparable) v2).compareTo(v1) :
                        ((Comparable) v1).compareTo(v2);
            }
            return 0;
        }
    }
};