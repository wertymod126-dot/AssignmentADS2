public class AccReqNode {
    AdminSimulation.AccountRequest request;
    AccReqNode next;
    public AccReqNode(AdminSimulation.AccountRequest request) {
        this.request = request;
        this.next = null;
    }
}
